package com.hx.utils;


import com.hx.cms.exception.OperateException;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author: tywei
 * @create: 2022-04-17 8:58 下午
 **/
public class ValidatorUtils {
    private static final Validator VALIDATOR;

    static {
        VALIDATOR = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }


    public static void validateEntity(Object object) throws OperateException {
        if (object == null) {
            throw new OperateException("参数不能为空");
        }
        Set<ConstraintViolation<Object>> constraintViolations = VALIDATOR.validate(object);
        if (!constraintViolations.isEmpty()) {
            throw new OperateException(constraintViolations.iterator().next().getMessage());
        }
    }

    /**
     * 校验对象
     *
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws OperateException 校验不通过，则报OperateException异常
     */
    public static void validateEntityByGroup(Object object, Class<?>... groups) throws OperateException {
        Set<ConstraintViolation<Object>> constraintViolations = VALIDATOR.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for (ConstraintViolation<Object> constraint : constraintViolations) {
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new OperateException(msg.toString());
        }
    }
}
