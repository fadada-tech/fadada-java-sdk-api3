package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.vo.Person;

/**
 * @author yh128
 * @className GetPersonInfoRsp
 * @description 获取个人信息返回对象
 * @createTime 2020年8月13日 15:11:05
 */
public class GetPersonInfoRsp extends BaseBean {

    private String unionId;

    private Integer status;

    private Person person;

    private PersonImageInfo imageInfo;

    public static class PersonImageInfo extends BaseBean {

        private String headPhotoPath;

        private String backgroundIdCardPath;

        private String photoUuid;

        private String gesturesPhotoPath;

        public String getHeadPhotoPath() {
            return headPhotoPath;
        }

        public void setHeadPhotoPath(String headPhotoPath) {
            this.headPhotoPath = headPhotoPath;
        }

        public String getBackgroundIdCardPath() {
            return backgroundIdCardPath;
        }

        public void setBackgroundIdCardPath(String backgroundIdCardPath) {
            this.backgroundIdCardPath = backgroundIdCardPath;
        }

        public String getPhotoUuid() {
            return photoUuid;
        }

        public void setPhotoUuid(String photoUuid) {
            this.photoUuid = photoUuid;
        }

        public String getGesturesPhotoPath() {
            return gesturesPhotoPath;
        }

        public void setGesturesPhotoPath(String gesturesPhotoPath) {
            this.gesturesPhotoPath = gesturesPhotoPath;
        }
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(PersonImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }
}
