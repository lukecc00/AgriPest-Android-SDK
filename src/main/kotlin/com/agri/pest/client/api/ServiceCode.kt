package com.agri.pest.client.api

/**
 * 全局业务错误码常量
 * 此文件由脚本自动从 Docs/API.md 生成，请勿手动修改
 */
object ServiceCode {
    /**
     * 请求成功
     * 原始信息: Success
     */
    const val SUCCESS = 200

    /**
     * 客户端提交的参数不符合要求（例如手机号格式错误）
     * 原始信息: 参数校验失败的具体信息
     */
    const val ERROR_400 = 400

    /**
     * 服务器内部发生未捕获的异常
     * 原始信息: Internal server error
     */
    const val INTERNAL_SERVER_ERROR = 5000

    /**
     * 请求参数缺失或不合法
     * 原始信息: Invalid request parameters
     */
    const val INVALID_REQUEST_PARAMETERS = 4000

    /**
     * 注册时用户名已被占用
     * 原始信息: Username already exists
     */
    const val USERNAME_ALREADY_EXISTS = 4001

    /**
     * 注册时手机号已被绑定
     * 原始信息: Phone number already exists
     */
    const val PHONE_NUMBER_ALREADY_EXISTS = 4002

    /**
     * 登录或刷新时未找到该用户
     * 原始信息: User not found
     */
    const val USER_NOT_FOUND = 4004

    /**
     * 账号或密码错误
     * 原始信息: Invalid username or password
     */
    const val INVALID_USERNAME_OR_PASSWORD = 4005

    /**
     * Token无效、伪造、版本号过期或已超时
     * 原始信息: Invalid token or token expired
     */
    const val INVALID_TOKEN_OR_TOKEN_EXPIRED = 4006

    /**
     * 短信验证码发送失败（第三方服务异常等）
     * 原始信息: Failed to send SMS code
     */
    const val FAILED_TO_SEND_SMS_CODE = 4007

    /**
     * 短信验证码填写错误或已过期
     * 原始信息: Invalid or expired SMS code
     */
    const val INVALID_OR_EXPIRED_SMS_CODE = 4008

    /**
     * 请求查看或操作的帖子不存在
     * 原始信息: Post not found
     */
    const val POST_NOT_FOUND = 4101

    /**
     * 请求操作的评论不存在
     * 原始信息: Comment not found
     */
    const val COMMENT_NOT_FOUND = 4102

    /**
     * 用户已经对该帖子点过赞，不能重复点赞
     * 原始信息: Post already liked
     */
    const val POST_ALREADY_LIKED = 4103

    /**
     * 用户已经收藏过该帖子，不能重复收藏
     * 原始信息: Post already favorited
     */
    const val POST_ALREADY_FAVORITED = 4104

    /**
     * 越权操作（例如尝试删除别人的帖子）
     * 原始信息: No permission to perform this action
     */
    const val NO_PERMISSION_TO_PERFORM_THIS_ACTION = 4105

    /**
     * 请求操作的作物不存在或不属于当前用户
     * 原始信息: Crop not found
     */
    const val CROP_NOT_FOUND = 4201

    /**
     * 用药打卡计划不存在
     * 原始信息: Medication plan not found
     */
    const val MEDICATION_PLAN_NOT_FOUND = 4202

    /**
     * 识别记录不存在
     * 原始信息: Detection record not found
     */
    const val DETECTION_RECORD_NOT_FOUND = 4301

    /**
     * 大模型识别服务不可用、超时或配置错误
     * 原始信息: AI service is currently unavailable
     */
    const val AI_SERVICE_IS_CURRENTLY_UNAVAILABLE = 4302

    /**
     * 文件上传到存储服务失败
     * 原始信息: File upload failed
     */
    const val FILE_UPLOAD_FAILED = 4401

    /**
     * 文件大小超过了服务器限制（通常为 10MB）
     * 原始信息: File size exceeds the maximum limit
     */
    const val FILE_SIZE_EXCEEDS_THE_MAXIMUM_LIMIT = 4402

    /**
     * 文件格式不允许（例如要求图片却上传了文本文件）
     * 原始信息: Invalid file type
     */
    const val INVALID_FILE_TYPE = 4403

}
