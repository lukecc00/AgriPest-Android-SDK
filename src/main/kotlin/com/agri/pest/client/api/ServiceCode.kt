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
     * 客户端提交的参数不符合要求
     * 原始信息: 参数校验失败的具体信息
     */
    const val ERROR_400 = 400

    /**
     * 服务器内部异常
     * 原始信息: Internal server error
     */
    const val INTERNAL_SERVER_ERROR = 5000

    /**
     * 请求参数缺失或不合法
     * 原始信息: Invalid request parameters
     */
    const val INVALID_REQUEST_PARAMETERS = 4000

    /**
     * 用户名已被占用
     * 原始信息: Username already exists
     */
    const val USERNAME_ALREADY_EXISTS = 4001

    /**
     * 手机号已被绑定
     * 原始信息: Phone number already exists
     */
    const val PHONE_NUMBER_ALREADY_EXISTS = 4002

    /**
     * 用户不存在
     * 原始信息: User not found
     */
    const val USER_NOT_FOUND = 4004

    /**
     * 账号或密码错误
     * 原始信息: Invalid username or password
     */
    const val INVALID_USERNAME_OR_PASSWORD = 4005

    /**
     * Token失效或已超时
     * 原始信息: Invalid token or token expired
     */
    const val INVALID_TOKEN_OR_TOKEN_EXPIRED = 4006

    /**
     * 短信发送失败
     * 原始信息: Failed to send SMS code
     */
    const val FAILED_TO_SEND_SMS_CODE = 4007

    /**
     * 验证码错误或过期
     * 原始信息: Invalid or expired SMS code
     */
    const val INVALID_OR_EXPIRED_SMS_CODE = 4008

    /**
     * 用户名长度不符 (2-15位)
     * 原始信息: Username length error
     */
    const val USERNAME_LENGTH_ERROR = 4009

    /**
     * 权限不足
     * 原始信息: Access denied
     */
    const val ACCESS_DENIED = 4003

    /**
     * 帖子不存在
     * 原始信息: Post not found
     */
    const val POST_NOT_FOUND = 4101

    /**
     * 评论不存在
     * 原始信息: Comment not found
     */
    const val COMMENT_NOT_FOUND = 4102

    /**
     * 不能重复点赞
     * 原始信息: Post already liked
     */
    const val POST_ALREADY_LIKED = 4103

    /**
     * 不能重复收藏
     * 原始信息: Post already favorited
     */
    const val POST_ALREADY_FAVORITED = 4104

    /**
     * 越权操作
     * 原始信息: No permission
     */
    const val NO_PERMISSION = 4105

    /**
     * 作物不存在
     * 原始信息: Crop not found
     */
    const val CROP_NOT_FOUND = 4201

    /**
     * 用药计划不存在
     * 原始信息: Medication plan not found
     */
    const val MEDICATION_PLAN_NOT_FOUND = 4202

    /**
     * 识别记录不存在
     * 原始信息: Detection record not found
     */
    const val DETECTION_RECORD_NOT_FOUND = 4301

    /**
     * AI 服务不可用
     * 原始信息: AI service unavailable
     */
    const val AI_SERVICE_UNAVAILABLE = 4302

    /**
     * 上传失败
     * 原始信息: File upload failed
     */
    const val FILE_UPLOAD_FAILED = 4401

    /**
     * 文件超过 10MB
     * 原始信息: File size exceeds limit
     */
    const val FILE_SIZE_EXCEEDS_LIMIT = 4402

    /**
     * 格式不支持 (仅限图片)
     * 原始信息: Invalid file type
     */
    const val INVALID_FILE_TYPE = 4403

    /**
     * 存储服务异常
     * 原始信息: Storage service error
     */
    const val STORAGE_SERVICE_ERROR = 4404

    /**
     * 消息不存在
     * 原始信息: Message not found
     */
    const val MESSAGE_NOT_FOUND = 4501

    /**
     * 管理员发布记录不存在
     * 原始信息: Admin record not found
     */
    const val ADMIN_RECORD_NOT_FOUND = 4502

}
