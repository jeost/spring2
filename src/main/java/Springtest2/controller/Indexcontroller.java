package Springtest2.controller;

import Springtest2.entity.TestEntity;
import Springtest2.entity.TestRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class Indexcontroller {
    @GetMapping("/main")
    public String home(){return "main";}

    @Autowired
    TestRepository testRepository;

    //main.js 내 메소드가 요청함
    @GetMapping("/save")
    @ResponseBody // HTML 말고 java 객체를 반환하는 어노테이션
    public String getdata(HttpServletRequest request){
        //변수 요청
        String content=request.getParameter("content");
        //엔티티 생성
        TestEntity testEntity=new TestEntity();
        testEntity.content=content;
        //엔티티 save
        testRepository.save(testEntity);
        //리턴
        return "작성완료";
    }
    @GetMapping("/getlist")
    public void getlist(HttpServletResponse response){
        //모든 entity 가져오기
        List<TestEntity> entities=testRepository.findAll();
        //JSON화 하기
        JSONArray array=new JSONArray();
        for(TestEntity entity:entities){
            JSONObject object=new JSONObject();
            object.put("no",entity.no);
            object.put("content",entity.content);
            array.put(object);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(array);
        }catch(Exception e){e.printStackTrace();}
    }
    //삭제 메소드
    @GetMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request){
        int no=Integer.parseInt(request.getParameter("no"));

        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);
        //Optional 객체 내 엔티티 삭제
        testRepository.delete(optionalTestEntity.get());
        return "1";
    }

    @GetMapping("/update")
    @ResponseBody
    @Transactional // 트랜잭션 어노테이션
    public String update(HttpServletRequest request){
        //변수 요청
        int no=Integer.parseInt(request.getParameter("no"));
        String content=request.getParameter("content");
        //pk값을 이용해 엔티티 찾기
        Optional<TestEntity> optionalTestEntity=testRepository.findById(no);
            // Optional : 제네릭에 해당하는 데이터 저장, null까지 저장
        //Optional 엔티티 빼오기
        TestEntity entity=optionalTestEntity.get();
        entity.content=content;
        return "1";
    }
}
