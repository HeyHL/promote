package io.hel.vo.req;

import io.hel.valid.PhoneCHN;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * helei
 * 2021/11/15 11:45
 * description:
 */
@SuppressWarnings("all")
@Data
@ApiModel(value = "create请求实体")
public class CreateReqVO implements Serializable {

    @ApiModelProperty(value = "标题", required = true)
//    @NotEmpty(message = "title cannot empty")
    @Length(min = 10, max = 15, message = "10-15")
    private String title;

//    @ApiModelProperty(value = "手机号", required = true)
//    @NotEmpty(message = "phone cannot empty")
//    @PhoneCHN()
//    private String phone;

    @ApiModelProperty(value = "类型")
    @Min(value = 1, message = "1")
    @Max(value = 2, message = "2")
//    @NotNull(message = "type cannot null")
    private Integer type = 1;

    @ApiModelProperty(value = "userId", required = true)
    private Long userId;
}
