package me.ridog.valentine.service.impl;

import com.google.common.collect.Lists;
import me.ridog.valentine.mapper.IMetaMapper;
import me.ridog.valentine.mapper.auto.MetaMapper;
import me.ridog.valentine.pojo.auto.Meta;
import me.ridog.valentine.result.MetaResult;
import me.ridog.valentine.service.IMetaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tate on 2016/8/1.
 */
@Service
public class MetaServiceImpl implements IMetaService {

    @Autowired
    private IMetaMapper MetaMapperEx;
    @Autowired
    private MetaMapper metaMapper;

    public List<MetaResult> getAll() {
        List<Meta> Metaes = MetaMapperEx.selectAll();
        ArrayList<MetaResult> metaResults = Lists.newArrayList();
        for (Meta metae : Metaes) {
            MetaResult metaResult = new MetaResult();
            BeanUtils.copyProperties(metaResult, metae);
            metaResults.add(metaResult);
        }
        return metaResults;
    }

    public int addMeta(Meta meta) {
        return metaMapper.insert(meta);
    }

    public int modifyMeta(Meta meta) {
        return metaMapper.updateByPrimaryKey(meta);
    }

    public void deleteMeta(Integer id) {
        metaMapper.deleteByPrimaryKey(id);
    }
}
