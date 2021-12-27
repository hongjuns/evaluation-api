package com.portfolio.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	  @Bean
	  public Docket api(){
	        return new Docket(DocumentationType.SWAGGER_2)
	        		  .useDefaultResponseMessages(false)  // �������� ����޽��� �̻��
	                  .globalResponseMessage(RequestMethod.POST, getArrayList()) // getArrayList()�Լ����� ������ ����޽��� ���
	                  .apiInfo(getApiInfo())
	                  .select()                   // return ApiSelectoorBuilder(ȭ�� ����)
	                  .apis(RequestHandlerSelectors.basePackage("com")) // Swagger�� ������ ��Ű��
	                  .paths(PathSelectors.any()) // url path ����(������� PathSelectors.ant("/home/**")�� ��� /home/ path�� ���� url�� �����ϰڴٴ� �ǹ�. any�� ��� ��ü url
	                  .build();                   // selector build
	  }
	

	  private ArrayList<ResponseMessage> getArrayList() {
	        ArrayList<ResponseMessage> lists = new ArrayList<ResponseMessage>();
	        lists.add(new ResponseMessageBuilder().code(500).message("�̻��ѿ�û").build());
	        lists.add(new ResponseMessageBuilder().code(403).message("Ȳ���ѿ�û").build());
	        lists.add(new ResponseMessageBuilder().code(401).message("������������").build());
	        return lists;
	    }
	  
	  
	   // �����׸�(Swagger UI���� �������� ����)
	   public ApiInfo getApiInfo() {
	        return new ApiInfo(
	        		"Service REST API Documentation",        // swagger ����
	                "REST Api Documentation",                // swagger ����
	                "1.0",                                   // swaggeer ����
	                "localhost:8080",
	                new Contact("hongjun","","asws12345@naver.com"), //�ۼ��� ����
	                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
	                new ArrayList<VendorExtension>());
	    }

}
