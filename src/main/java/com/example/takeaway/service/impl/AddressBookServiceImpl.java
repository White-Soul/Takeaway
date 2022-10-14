package com.example.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.takeaway.entity.AddressBook;
import com.example.takeaway.service.AddressBookService;
import com.example.takeaway.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 24343
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-10-13 11:07:56
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
implements AddressBookService{

}
