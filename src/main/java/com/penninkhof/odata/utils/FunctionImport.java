package com.penninkhof.odata.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.api.annotation.edm.EdmFacets;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.HttpMethod;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.penninkhof.odata.repository.MemberRepository;

@Component
public class FunctionImport {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public FunctionImport() {
		ApplicationContextProvider appContextProvider = new ApplicationContextProvider();
		ApplicationContext applicationContext = appContextProvider.getApplicationContext();
		if (applicationContext != null) {
			applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
		}

	}

	@Autowired
	private MemberRepository memberRepository;

	@EdmFunctionImport(name = "Test", returnType = @ReturnType(type = Type.SIMPLE, isCollection = false), httpMethod = HttpMethod.GET)
	public boolean checkATP(
			@EdmFunctionImportParameter(name = "Test1", facets = @EdmFacets(nullable = false)) final Long soID,
			@EdmFunctionImportParameter(name = "Test2", facets = @EdmFacets(nullable = false)) final Long lineItemID) {
//		if (soID == 2L) {
//			return false;
//		} else {
//			return true;
//		}

		EntityManager em = entityManagerFactory.createEntityManager();
		// List<Member> member = memberRepository.findByLastName("Bauer");

		em.close();

//		try {
//			String sql = "SELECT * FROM Member e";
//			Query query = entityManager.createQuery(sql);
//			query.getSingleResult();
//		} catch (NoResultException e) {
//			return false;
//		}

		// List<Member> member = memberRepository.findByLastName("Bauer");

		return true;
	}

}
