package org.luopanbi.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.common.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public R<User> getUser(@PathVariable("id") Integer id) {
        return R.ok(userMapper.selectById(id));
    }

    @GetMapping("/")
    public R<PageResult<User>> getAll(PageParam pageParam) {
        Page<User> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
        userMapper.selectPage(page, new QueryWrapper<>());
        return R.ok(PageResult.from(page));
    }
}
