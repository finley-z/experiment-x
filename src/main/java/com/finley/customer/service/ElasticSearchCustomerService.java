package com.finley.customer.service;


import com.finley.customer.entity.ESCustomer;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetSocketAddress;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;


@Service
public class ElasticSearchCustomerService {

//    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 修改客户
     *
     * @param entity
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean addCustomer(ESCustomer entity) {
        elasticsearchTemplate=getTemplate();
        if(!elasticsearchTemplate.indexExists("loans2")){
            elasticsearchTemplate.createIndex("loans2");
        }
        IndexQuery query = new IndexQueryBuilder().withObject(entity).build();
        elasticsearchTemplate.index(query);
        return true;
    }


    /***
     *条件查询客户
     * @param entity
     * @return
     */
    public List<ESCustomer> getCustomers(ESCustomer entity) {
        elasticsearchTemplate=getTemplate();
        Pageable pageable=new PageRequest(0,10);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(multiMatchQuery("13027236862", "customerName","nickName","mobile")).withSort(SortBuilders.fieldSort("customerId").sortMode(SortMode.MAX)).build();

//        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery("13027236862", "customerName","nickName","mobile");
//
//        searchFunction(queryBuilder,elasticsearchTemplate.getClient());
        return elasticsearchTemplate.queryForList(searchQuery, ESCustomer.class);

    }


    public ESCustomer getCustomer(Integer customerId) {
        return null;
    }

    private ElasticsearchTemplate getTemplate() {
        /**
         * put("client.transport.sniff", true)启动嗅探功能,客户端去嗅探整个集群的状态，
         * 把集群中其它机器的ip地址加到客户端中，这样做的好处是一般你不用手动设置集群里所
         * 有集群的ip到连接客户端，它会自动帮你添加，并且自动发现新加入集群的机器。
         */
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch")//设置集群名字
                .put("client.transport.sniff", true)//
                .build();

        Client client =new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1",9300)));
        ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(client);
        elasticsearchTemplate.putMapping(ESCustomer.class);
        return elasticsearchTemplate;
    }

    private void searchFunction(QueryBuilder queryBuilder, Client client) {
        /**
         * SearchType
         * 1、query and fetch
         * 索引的所有分片（shard）都发出查询请求，各分片返回的时候把元素文档（document）
         * 和计算后的排名信息一起返回。这种搜索方式是最快的。因为相比下面的几种搜索方式，
         * 这种查询方法只需要去shard查询一次。但是各个shard返回的结果的数量之和可能是用户要求的size的n倍。
         *
         * 2、query then fetch（默认的搜索方式） 如果你搜索时，没有指定搜索方式，就是使用的这种搜索方式。
         * 这种搜索方式，大概分两个步骤，第一步，先向所有的shard发出请求，各分片只返回排序和排名相关的信息（注意，不包括文档document)，
         * 然后按照各分片返回的分数进行重新排序和排名，取前size个文档。然后进行第二步，去相关的shard取document。
         * 这种方式返回的document可能是用户要求的size的n倍，但是由于内部机制的问题query then fetch会比query and fetch占用更多的内存
         *
         * 3、DFS query and fetch
         * 这种方式比第一种方式多了一个初始化散发(initial scatter)步骤，有这一步，
         * 据说可以更精确控制搜索打分和排名。这种方式返回的document与用户要求的size是相等的。
         *
         * 4、DFS query then fetch 比第2种方式多了一个初始化散发(initial scatter)步骤。
         * 这种方式返回的document与用户要求的size是相等的。
         *
         * DSF表示初始化散发，从es的官方网站我们可以指定，初始化散发其实就是在进行真正的查询之前，
         * 先把各个分片的词频率和文档频率收集一下，然后进行词搜索的时候，
         * 各分片依据全局的词频率和文档频率进行搜索和排名。显然如果使用DFS_QUERY_THEN_FETCH
         * 这种查询方式，效率是最低的，因为一个搜索，可能要请求3次分片。但，使用DFS方法，搜索精度应该是最高的。
         *
         * 总结一下，从性能考虑QUERY_AND_FETCH是最快的，DFS_QUERY_THEN_FETCH是最慢的。
         * 从搜索的准确度来说，DFS要比非DFS的准确度更高。
         *
         *
         * setExplain为true表示根据数据相关度排序，和关键字匹配最高的排在前面
         *
         * addSort添加排序方式
         */
        SearchResponse response = client.prepareSearch("loans2").setTypes("customer_es2")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setExplain(true)
                .setQuery(queryBuilder)
//                .addSort("id", SortOrder.ASC)
                .setSize(100).execute().actionGet();
        System.out.println(response.toString());

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSource());

            if (hit.getHighlightFields() != null && hit.getHighlightFields().size() != 0) {
                Text[] texts = hit.getHighlightFields().get("title").getFragments();
                for (Text text : texts) {
                    System.out.println(text.string() + ",");
                }
            }

        }
    }
}
