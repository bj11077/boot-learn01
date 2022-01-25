package com.fertilizer.back.controller.eleasticExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fertilizer.back.dto.elasticExam.ElasticExamDto;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ElasticExamController {

    public RestHighLevelClient createConnection() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.0.5",9200,"http")
                )
        );
    }


    @RequestMapping(value = "/es/user", method = RequestMethod.GET)
    public Object userSearch(@RequestParam( name ="fromDate", required = false) String fromDate, @RequestParam(name ="toDate", required = false) String toDate){
        String aliasName = "user-topic";
        String typeName = "_doc";

        String fieldName = "systemTime";
        System.out.println(fromDate);
        System.out.println(toDate);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();


        //UTC라 +9필요					//데이터형식 : from("2022-01-13T16:12:00+09:00").to(" ")
        searchSourceBuilder.query(QueryBuilders.rangeQuery("@timestamp").from(fromDate+"+09:00").to(toDate+"+09:00"));
        searchSourceBuilder.size(10000);

        SearchRequest request = new SearchRequest(aliasName);
        request.source(searchSourceBuilder);


        SearchResponse response = null;
        SearchHits searchHits = null;
        List<ElasticExamDto> resultMap = new ArrayList<>();


        try(RestHighLevelClient client = createConnection();){

            response = client.search(request, RequestOptions.DEFAULT);
            searchHits = response.getHits();
            for( SearchHit hit : searchHits) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                ElasticExamDto a = new ElasticExamDto();
                a.setUserName(sourceAsMap.get("username")+"");
                a.setAttendanceCount(sourceAsMap.get("attendanceCount")+"");
                a.setMemberSince(sourceAsMap.get("memberSince")+"");
                resultMap.add(a);


            }





        }catch (Exception e) {
            /*
             * 예외처리
             */
            e.printStackTrace();
        }

//        return gson.toJson(response);
//        return gson.toJson(resultMap);
        return resultMap;
//        return searchHits;
    }






}
