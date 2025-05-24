package com.wangwangmumu.weblog.admin.model.vo.tag;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: 犬小哈
 * @url: www.wangwangmumu.com
 * @date: 2023-09-15 14:07
 * @description: 标签模糊查询
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "标签模糊查询 VO")
public class SearchTagsReqVO {

    @NotBlank(message = "标签查询关键词不能为空")
    private String key;

}
