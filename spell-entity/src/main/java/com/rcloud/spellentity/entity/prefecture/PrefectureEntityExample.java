package com.rcloud.spellentity.entity.prefecture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrefectureEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PrefectureEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPrefectureIdIsNull() {
            addCriterion("prefecture_id is null");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdIsNotNull() {
            addCriterion("prefecture_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdEqualTo(Integer value) {
            addCriterion("prefecture_id =", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdNotEqualTo(Integer value) {
            addCriterion("prefecture_id <>", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdGreaterThan(Integer value) {
            addCriterion("prefecture_id >", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prefecture_id >=", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdLessThan(Integer value) {
            addCriterion("prefecture_id <", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdLessThanOrEqualTo(Integer value) {
            addCriterion("prefecture_id <=", value, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdIn(List<Integer> values) {
            addCriterion("prefecture_id in", values, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdNotIn(List<Integer> values) {
            addCriterion("prefecture_id not in", values, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdBetween(Integer value1, Integer value2) {
            addCriterion("prefecture_id between", value1, value2, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prefecture_id not between", value1, value2, "prefectureId");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameIsNull() {
            addCriterion("prefecture_name is null");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameIsNotNull() {
            addCriterion("prefecture_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameEqualTo(String value) {
            addCriterion("prefecture_name =", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameNotEqualTo(String value) {
            addCriterion("prefecture_name <>", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameGreaterThan(String value) {
            addCriterion("prefecture_name >", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameGreaterThanOrEqualTo(String value) {
            addCriterion("prefecture_name >=", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameLessThan(String value) {
            addCriterion("prefecture_name <", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameLessThanOrEqualTo(String value) {
            addCriterion("prefecture_name <=", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameLike(String value) {
            addCriterion("prefecture_name like", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameNotLike(String value) {
            addCriterion("prefecture_name not like", value, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameIn(List<String> values) {
            addCriterion("prefecture_name in", values, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameNotIn(List<String> values) {
            addCriterion("prefecture_name not in", values, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameBetween(String value1, String value2) {
            addCriterion("prefecture_name between", value1, value2, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPrefectureNameNotBetween(String value1, String value2) {
            addCriterion("prefecture_name not between", value1, value2, "prefectureName");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNull() {
            addCriterion("page_path is null");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNotNull() {
            addCriterion("page_path is not null");
            return (Criteria) this;
        }

        public Criteria andPagePathEqualTo(String value) {
            addCriterion("page_path =", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotEqualTo(String value) {
            addCriterion("page_path <>", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThan(String value) {
            addCriterion("page_path >", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThanOrEqualTo(String value) {
            addCriterion("page_path >=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThan(String value) {
            addCriterion("page_path <", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThanOrEqualTo(String value) {
            addCriterion("page_path <=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLike(String value) {
            addCriterion("page_path like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotLike(String value) {
            addCriterion("page_path not like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathIn(List<String> values) {
            addCriterion("page_path in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotIn(List<String> values) {
            addCriterion("page_path not in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathBetween(String value1, String value2) {
            addCriterion("page_path between", value1, value2, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotBetween(String value1, String value2) {
            addCriterion("page_path not between", value1, value2, "pagePath");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNull() {
            addCriterion("is_status is null");
            return (Criteria) this;
        }

        public Criteria andIsStatusIsNotNull() {
            addCriterion("is_status is not null");
            return (Criteria) this;
        }

        public Criteria andIsStatusEqualTo(Integer value) {
            addCriterion("is_status =", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotEqualTo(Integer value) {
            addCriterion("is_status <>", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThan(Integer value) {
            addCriterion("is_status >", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_status >=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThan(Integer value) {
            addCriterion("is_status <", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("is_status <=", value, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusIn(List<Integer> values) {
            addCriterion("is_status in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotIn(List<Integer> values) {
            addCriterion("is_status not in", values, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusBetween(Integer value1, Integer value2) {
            addCriterion("is_status between", value1, value2, "isStatus");
            return (Criteria) this;
        }

        public Criteria andIsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("is_status not between", value1, value2, "isStatus");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}