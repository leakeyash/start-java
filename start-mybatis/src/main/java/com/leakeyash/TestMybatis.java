package com.leakeyash;

import com.leakeyash.mybatis.data.Category;
import com.leakeyash.mybatis.data.Product;
import com.leakeyash.mybatis.data.ProductMapper;
import com.leakeyash.mybatis.data.SearchCondition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setSize(88);
        searchCondition.setPrice(8.8f);
        searchCondition.setContainsSize(true);
        searchCondition.setCategories(new String[]{"swap"});
        //searchCondition.setCategories(new String[]{});

        ProductMapper productMapper = session.getMapper(ProductMapper.class);
        List<Product> products  = productMapper.findProductBySearchCondition(searchCondition);
        //= session.selectList("selectProducts",searchCondition);
        System.out.println(products);
        session.close();
    }

    private static void listAll(SqlSession session){
        List<Category> cs=session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }

    private static void test(SqlSession session){
        Category c = new Category();
        c.setName("新增加的Category");
        session.insert("addCategory",c);
        System.out.println(c.getId());

        Category cGet= session.selectOne("getCategory",4);

        System.out.println(cGet.getName());

        Category cToDelete = new Category();
        cToDelete.setId(6);
        session.delete("deleteCategory",cToDelete);

        Category cAdd = new Category();
        cAdd.setName("add");
        session.delete("addCategory",cAdd);

        Category cUpdate= session.selectOne("getCategory",4);
        cUpdate.setName("修改了的Category名称");
        session.update("updateCategory",cUpdate);

        listAll(session);

        session.commit();

        Product p1 = new Product();
        p1.setName("vanilla swap");
        p1.setCategory("swap");
        p1.setPrice(8.8f);
        p1.setSize(88);
        session.insert("addProduct",p1);

        Product p2 = new Product();
        p2.setName("basic swap");
        p2.setCategory("swap");
        p2.setPrice(8.9f);
        p2.setSize(88);
        session.insert("addProduct",p2);

        Product p3 = new Product();
        p3.setName("single leg swap");
        p3.setCategory("swap");
        p3.setPrice(8.8f);
        p3.setSize(88);
        session.insert("addProduct",p3);

        Product p4 = new Product();
        p4.setName("capfloor");
        p4.setCategory("capfloor");
        p4.setPrice(8.8f);
        p4.setSize(88);
        session.insert("addProduct",p4);

        Product p5 = new Product();
        p5.setName("cds swap");
        p5.setCategory("swap");
        p5.setPrice(8.8f);
        p5.setSize(889);
        session.insert("addProduct",p5);
    }
}
