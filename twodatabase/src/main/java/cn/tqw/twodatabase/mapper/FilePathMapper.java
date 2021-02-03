package cn.tqw.twodatabase.mapper;


import cn.tqw.twodatabase.pojo.FilePath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FilePathMapper {
    FilePath findFilePathByID(@Param("ID") String ID);
}
