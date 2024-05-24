package cn.controller;

import cn.entity.User;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import cn.services.IUser;
import cn.utils.ResponseUtil;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Objects;

/**
 * 用户管理
 *
 * @Description
 * @Author myf
 * @CreateDate 2020/11/10 10:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUser userService;

    /**
     * 根据名称查询用户信息
     *
     * @param name
     * @return
     */
    @RequestMapping("/getUser/{name}")
    public ResponseUtil<User> getUserInfoByName(@PathVariable String name) {
        ResponseUtil<User> responseUtil = new ResponseUtil<>();
        User user = userService.getUserByName(name);
        if (Objects.isNull(user)) {
            responseUtil.resFail("没有指定名称的用户！");
            return responseUtil;
        }
        responseUtil.resSuccess();
        responseUtil.setData(null);
        return responseUtil;
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public ResponseUtil addUser(@RequestBody User user) {
        ResponseUtil responseUtil = new ResponseUtil<>();
        userService.addUser(user);
        responseUtil.resSuccess();
        responseUtil.setData(null);
        return responseUtil;
    }

    /**
     * 全量导出用户
     *
     * @return
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        userService.export(response);
    }

    /**
     * 生成二维码
     *
     * @return
     */
    @GetMapping("/getQrCode")
    public ResponseUtil<HashMap<String, Object>> getQrCode(HttpServletResponse response) {
        HashMap<String, Object> map = new HashMap<>();
        QrConfig config = new QrConfig(300, 300);
        config.setMargin(3); // 设置边距
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        String base64 = QrCodeUtil.generateAsBase64("hello", config, "png");

        map.put("src", base64);
        map.put("name", "myf");
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.resSuccess();
        responseUtil.setData(map);
        return responseUtil;
    }
}
