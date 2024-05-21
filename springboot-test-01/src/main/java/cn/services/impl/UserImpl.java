package cn.services.impl;

import cn.entity.User;
import cn.hutool.core.bean.BeanUtil;
import cn.mapper.UserMapper;
import cn.services.IUser;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/11/9 19:57
 * @Version 1.0
 **/
@Service
public class UserImpl implements IUser {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void export(HttpServletResponse response) {
        List<User> userList = userMapper.selectAll();
        String filename = System.currentTimeMillis()+".xlsx";

        // 设置响应参数
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);

        try {
            EasyExcel.write(response.getOutputStream()).head(head()).sheet("用户数据").doWrite(dealExportData(userList));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<List<Object>> dealExportData(List<User> userList) {
        List<List<Object>> collect = userList.stream().map(user -> {
            List<Object> list = new ArrayList<Object>();
            Map<String, Object> map = BeanUtil.beanToMap(user);
            list.addAll(map.values());
            addMonthData(list);
            return list;
        }).collect(Collectors.toList());
        return collect;
    }

    private void addMonthData(List<Object> list) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.with(TemporalAdjusters.firstDayOfMonth());
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd", Locale.CHINA);
        LocalDate end = now.with(TemporalAdjusters.lastDayOfMonth());
        for (LocalDate i = start; !i.isAfter(end);i=i.plusDays(1)) {
            String day = dateTimeFormatter2.format(i);
            list.add(day);
        }
    }

    /**
     * 获取导出头信息
     * @return
     */
    private List<List<String>> head() {
        List<List<String>> list = ListUtils.newArrayList();

        list.add(Lists.newArrayList("用户信息","id"));
        list.add(Lists.newArrayList("用户信息","姓名"));

        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月", Locale.CHINA);
        String monthName = dateTimeFormatter.format(now);

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("dd", Locale.CHINA);

        LocalDate start = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate end = now.with(TemporalAdjusters.lastDayOfMonth());
        for (LocalDate i = start; !i.isAfter(end);i=i.plusDays(1)) {
            list.add(Lists.newArrayList(monthName,dateTimeFormatter2.format(i)));
        }
        return list;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
