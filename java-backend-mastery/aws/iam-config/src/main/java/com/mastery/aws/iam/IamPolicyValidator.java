package com.mastery.aws.iam;

public class IamPolicyValidator {

    public boolean isLeastPrivilege(String action, String resourceArn) {
        return !"*".equals(action)
                && !"*".equals(resourceArn)
                && resourceArn.startsWith("arn:aws:");
    }
}
