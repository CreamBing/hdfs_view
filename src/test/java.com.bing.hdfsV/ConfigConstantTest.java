
import com.bing.hdfsV.HdfsViewApp;
import com.bing.hdfsV.constant.ConfigConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 测试常量类能否拿到配置值
 * Created by zhaobing on 2016/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = HdfsViewApp.class)
public class ConfigConstantTest {

    @Autowired
    private ConfigConstant constant;


    @Test
    public void getRootPathTest(){
        String hdfsRoot = ConfigConstant.ROOT_PATH;
        assertThat(hdfsRoot,is("hdfs://localhost:9000/"));
    }

    @Test
    public void initTest(){
        constant.init();
        String hdfsRoot = ConfigConstant.ROOT_PATH;
        assertThat(hdfsRoot,is("hdfs://localhost:9000/"));
    }
}
