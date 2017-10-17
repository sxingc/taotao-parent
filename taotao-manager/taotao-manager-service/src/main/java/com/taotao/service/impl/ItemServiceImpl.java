package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chen on 2017/10/16.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper itemMapper;


    @Override
    public TbItem getItemById(long itemId) {
//        TbItem item= itemMapper.selectByPrimaryKey(itemId);
        TbItemExample example=new TbItemExample();
//        创建查询条件
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(itemId);
        TbItem item=null;
        List<TbItem> list= itemMapper.selectByExample(example);
        if (list!=null&&list.size()>0){
            item=list.get(0);
        }
        return item;
    }
}
