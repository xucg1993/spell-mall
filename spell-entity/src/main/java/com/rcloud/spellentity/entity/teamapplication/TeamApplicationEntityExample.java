package com.rcloud.spellentity.entity.teamapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamApplicationEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamApplicationEntityExample() {
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

        public Criteria andTaIdIsNull() {
            addCriterion("ta_id is null");
            return (Criteria) this;
        }

        public Criteria andTaIdIsNotNull() {
            addCriterion("ta_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaIdEqualTo(Integer value) {
            addCriterion("ta_id =", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdNotEqualTo(Integer value) {
            addCriterion("ta_id <>", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdGreaterThan(Integer value) {
            addCriterion("ta_id >", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ta_id >=", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdLessThan(Integer value) {
            addCriterion("ta_id <", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ta_id <=", value, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdIn(List<Integer> values) {
            addCriterion("ta_id in", values, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdNotIn(List<Integer> values) {
            addCriterion("ta_id not in", values, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdBetween(Integer value1, Integer value2) {
            addCriterion("ta_id between", value1, value2, "taId");
            return (Criteria) this;
        }

        public Criteria andTaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ta_id not between", value1, value2, "taId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoenIsNull() {
            addCriterion("phoen is null");
            return (Criteria) this;
        }

        public Criteria andPhoenIsNotNull() {
            addCriterion("phoen is not null");
            return (Criteria) this;
        }

        public Criteria andPhoenEqualTo(String value) {
            addCriterion("phoen =", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenNotEqualTo(String value) {
            addCriterion("phoen <>", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenGreaterThan(String value) {
            addCriterion("phoen >", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenGreaterThanOrEqualTo(String value) {
            addCriterion("phoen >=", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenLessThan(String value) {
            addCriterion("phoen <", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenLessThanOrEqualTo(String value) {
            addCriterion("phoen <=", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenLike(String value) {
            addCriterion("phoen like", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenNotLike(String value) {
            addCriterion("phoen not like", value, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenIn(List<String> values) {
            addCriterion("phoen in", values, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenNotIn(List<String> values) {
            addCriterion("phoen not in", values, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenBetween(String value1, String value2) {
            addCriterion("phoen between", value1, value2, "phoen");
            return (Criteria) this;
        }

        public Criteria andPhoenNotBetween(String value1, String value2) {
            addCriterion("phoen not between", value1, value2, "phoen");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andWechatNumberIsNull() {
            addCriterion("wechat_number is null");
            return (Criteria) this;
        }

        public Criteria andWechatNumberIsNotNull() {
            addCriterion("wechat_number is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNumberEqualTo(String value) {
            addCriterion("wechat_number =", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberNotEqualTo(String value) {
            addCriterion("wechat_number <>", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberGreaterThan(String value) {
            addCriterion("wechat_number >", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_number >=", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberLessThan(String value) {
            addCriterion("wechat_number <", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberLessThanOrEqualTo(String value) {
            addCriterion("wechat_number <=", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberLike(String value) {
            addCriterion("wechat_number like", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberNotLike(String value) {
            addCriterion("wechat_number not like", value, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberIn(List<String> values) {
            addCriterion("wechat_number in", values, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberNotIn(List<String> values) {
            addCriterion("wechat_number not in", values, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberBetween(String value1, String value2) {
            addCriterion("wechat_number between", value1, value2, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andWechatNumberNotBetween(String value1, String value2) {
            addCriterion("wechat_number not between", value1, value2, "wechatNumber");
            return (Criteria) this;
        }

        public Criteria andExplainIsNull() {
            addCriterion("explain is null");
            return (Criteria) this;
        }

        public Criteria andExplainIsNotNull() {
            addCriterion("explain is not null");
            return (Criteria) this;
        }

        public Criteria andExplainEqualTo(String value) {
            addCriterion("explain =", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotEqualTo(String value) {
            addCriterion("explain <>", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThan(String value) {
            addCriterion("explain >", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainGreaterThanOrEqualTo(String value) {
            addCriterion("explain >=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThan(String value) {
            addCriterion("explain <", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLessThanOrEqualTo(String value) {
            addCriterion("explain <=", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainLike(String value) {
            addCriterion("explain like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotLike(String value) {
            addCriterion("explain not like", value, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainIn(List<String> values) {
            addCriterion("explain in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotIn(List<String> values) {
            addCriterion("explain not in", values, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainBetween(String value1, String value2) {
            addCriterion("explain between", value1, value2, "explain");
            return (Criteria) this;
        }

        public Criteria andExplainNotBetween(String value1, String value2) {
            addCriterion("explain not between", value1, value2, "explain");
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