package com.example.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.takeaway.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24343
* @description 针对表【address_book(地址管理)】的数据库操作Mapper
* @createDate 2022-10-13 11:07:56
* @Entity com.example.takeaway.entity.AddressBook
*/
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {


}
