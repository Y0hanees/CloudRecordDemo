package springcloud.comtroller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @USER: Yohanes
 * @DATE: 2021/2/5 13:56
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L,"2fsgjifisnwerwere4rewrwvfs6htriyt"));
        hashMap.put(1L,new Payment(2L,"bfsgjifisnw312321re4rewrwvfs6htyt"));
        hashMap.put(1L,new Payment(3L,"3fsgjifiertetretretreertfs6htriyt"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort:" + serverPort,payment);
        return result;
    }
}
