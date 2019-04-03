package com.rcloud.spellentity.entity.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsEntityExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionIsNull() {
            addCriterion("goods_promotion is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionIsNotNull() {
            addCriterion("goods_promotion is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionEqualTo(String value) {
            addCriterion("goods_promotion =", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionNotEqualTo(String value) {
            addCriterion("goods_promotion <>", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionGreaterThan(String value) {
            addCriterion("goods_promotion >", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionGreaterThanOrEqualTo(String value) {
            addCriterion("goods_promotion >=", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionLessThan(String value) {
            addCriterion("goods_promotion <", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionLessThanOrEqualTo(String value) {
            addCriterion("goods_promotion <=", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionLike(String value) {
            addCriterion("goods_promotion like", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionNotLike(String value) {
            addCriterion("goods_promotion not like", value, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionIn(List<String> values) {
            addCriterion("goods_promotion in", values, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionNotIn(List<String> values) {
            addCriterion("goods_promotion not in", values, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionBetween(String value1, String value2) {
            addCriterion("goods_promotion between", value1, value2, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andGoodsPromotionNotBetween(String value1, String value2) {
            addCriterion("goods_promotion not between", value1, value2, "goodsPromotion");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andLineationPriceIsNull() {
            addCriterion("lineation_price is null");
            return (Criteria) this;
        }

        public Criteria andLineationPriceIsNotNull() {
            addCriterion("lineation_price is not null");
            return (Criteria) this;
        }

        public Criteria andLineationPriceEqualTo(Integer value) {
            addCriterion("lineation_price =", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceNotEqualTo(Integer value) {
            addCriterion("lineation_price <>", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceGreaterThan(Integer value) {
            addCriterion("lineation_price >", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("lineation_price >=", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceLessThan(Integer value) {
            addCriterion("lineation_price <", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceLessThanOrEqualTo(Integer value) {
            addCriterion("lineation_price <=", value, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceIn(List<Integer> values) {
            addCriterion("lineation_price in", values, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceNotIn(List<Integer> values) {
            addCriterion("lineation_price not in", values, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceBetween(Integer value1, Integer value2) {
            addCriterion("lineation_price between", value1, value2, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andLineationPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("lineation_price not between", value1, value2, "lineationPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNull() {
            addCriterion("retail_price is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(Integer value) {
            addCriterion("retail_price =", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(Integer value) {
            addCriterion("retail_price <>", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(Integer value) {
            addCriterion("retail_price >", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("retail_price >=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(Integer value) {
            addCriterion("retail_price <", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(Integer value) {
            addCriterion("retail_price <=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<Integer> values) {
            addCriterion("retail_price in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<Integer> values) {
            addCriterion("retail_price not in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(Integer value1, Integer value2) {
            addCriterion("retail_price between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("retail_price not between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceIsNull() {
            addCriterion("enter_price is null");
            return (Criteria) this;
        }

        public Criteria andEnterPriceIsNotNull() {
            addCriterion("enter_price is not null");
            return (Criteria) this;
        }

        public Criteria andEnterPriceEqualTo(Integer value) {
            addCriterion("enter_price =", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceNotEqualTo(Integer value) {
            addCriterion("enter_price <>", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceGreaterThan(Integer value) {
            addCriterion("enter_price >", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_price >=", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceLessThan(Integer value) {
            addCriterion("enter_price <", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceLessThanOrEqualTo(Integer value) {
            addCriterion("enter_price <=", value, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceIn(List<Integer> values) {
            addCriterion("enter_price in", values, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceNotIn(List<Integer> values) {
            addCriterion("enter_price not in", values, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceBetween(Integer value1, Integer value2) {
            addCriterion("enter_price between", value1, value2, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andEnterPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_price not between", value1, value2, "enterPrice");
            return (Criteria) this;
        }

        public Criteria andColonelIsNull() {
            addCriterion("colonel is null");
            return (Criteria) this;
        }

        public Criteria andColonelIsNotNull() {
            addCriterion("colonel is not null");
            return (Criteria) this;
        }

        public Criteria andColonelEqualTo(Integer value) {
            addCriterion("colonel =", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotEqualTo(Integer value) {
            addCriterion("colonel <>", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelGreaterThan(Integer value) {
            addCriterion("colonel >", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelGreaterThanOrEqualTo(Integer value) {
            addCriterion("colonel >=", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelLessThan(Integer value) {
            addCriterion("colonel <", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelLessThanOrEqualTo(Integer value) {
            addCriterion("colonel <=", value, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelIn(List<Integer> values) {
            addCriterion("colonel in", values, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotIn(List<Integer> values) {
            addCriterion("colonel not in", values, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelBetween(Integer value1, Integer value2) {
            addCriterion("colonel between", value1, value2, "colonel");
            return (Criteria) this;
        }

        public Criteria andColonelNotBetween(Integer value1, Integer value2) {
            addCriterion("colonel not between", value1, value2, "colonel");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeEqualTo(Integer value) {
            addCriterion("shipping_fee =", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotEqualTo(Integer value) {
            addCriterion("shipping_fee <>", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThan(Integer value) {
            addCriterion("shipping_fee >", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipping_fee >=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThan(Integer value) {
            addCriterion("shipping_fee <", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThanOrEqualTo(Integer value) {
            addCriterion("shipping_fee <=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIn(List<Integer> values) {
            addCriterion("shipping_fee in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotIn(List<Integer> values) {
            addCriterion("shipping_fee not in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeBetween(Integer value1, Integer value2) {
            addCriterion("shipping_fee between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("shipping_fee not between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgIsNull() {
            addCriterion("goods_major_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgIsNotNull() {
            addCriterion("goods_major_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgEqualTo(String value) {
            addCriterion("goods_major_img =", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgNotEqualTo(String value) {
            addCriterion("goods_major_img <>", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgGreaterThan(String value) {
            addCriterion("goods_major_img >", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_major_img >=", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgLessThan(String value) {
            addCriterion("goods_major_img <", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgLessThanOrEqualTo(String value) {
            addCriterion("goods_major_img <=", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgLike(String value) {
            addCriterion("goods_major_img like", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgNotLike(String value) {
            addCriterion("goods_major_img not like", value, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgIn(List<String> values) {
            addCriterion("goods_major_img in", values, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgNotIn(List<String> values) {
            addCriterion("goods_major_img not in", values, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgBetween(String value1, String value2) {
            addCriterion("goods_major_img between", value1, value2, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsMajorImgNotBetween(String value1, String value2) {
            addCriterion("goods_major_img not between", value1, value2, "goodsMajorImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgIsNull() {
            addCriterion("goods_slideshow_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgIsNotNull() {
            addCriterion("goods_slideshow_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgEqualTo(String value) {
            addCriterion("goods_slideshow_img =", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgNotEqualTo(String value) {
            addCriterion("goods_slideshow_img <>", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgGreaterThan(String value) {
            addCriterion("goods_slideshow_img >", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_slideshow_img >=", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgLessThan(String value) {
            addCriterion("goods_slideshow_img <", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgLessThanOrEqualTo(String value) {
            addCriterion("goods_slideshow_img <=", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgLike(String value) {
            addCriterion("goods_slideshow_img like", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgNotLike(String value) {
            addCriterion("goods_slideshow_img not like", value, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgIn(List<String> values) {
            addCriterion("goods_slideshow_img in", values, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgNotIn(List<String> values) {
            addCriterion("goods_slideshow_img not in", values, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgBetween(String value1, String value2) {
            addCriterion("goods_slideshow_img between", value1, value2, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsSlideshowImgNotBetween(String value1, String value2) {
            addCriterion("goods_slideshow_img not between", value1, value2, "goodsSlideshowImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgIsNull() {
            addCriterion("goods_details_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgIsNotNull() {
            addCriterion("goods_details_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgEqualTo(String value) {
            addCriterion("goods_details_img =", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgNotEqualTo(String value) {
            addCriterion("goods_details_img <>", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgGreaterThan(String value) {
            addCriterion("goods_details_img >", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_details_img >=", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgLessThan(String value) {
            addCriterion("goods_details_img <", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_details_img <=", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgLike(String value) {
            addCriterion("goods_details_img like", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgNotLike(String value) {
            addCriterion("goods_details_img not like", value, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgIn(List<String> values) {
            addCriterion("goods_details_img in", values, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgNotIn(List<String> values) {
            addCriterion("goods_details_img not in", values, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgBetween(String value1, String value2) {
            addCriterion("goods_details_img between", value1, value2, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsImgNotBetween(String value1, String value2) {
            addCriterion("goods_details_img not between", value1, value2, "goodsDetailsImg");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andRepertoryIsNull() {
            addCriterion("repertory is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryIsNotNull() {
            addCriterion("repertory is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryEqualTo(Integer value) {
            addCriterion("repertory =", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryNotEqualTo(Integer value) {
            addCriterion("repertory <>", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryGreaterThan(Integer value) {
            addCriterion("repertory >", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("repertory >=", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryLessThan(Integer value) {
            addCriterion("repertory <", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryLessThanOrEqualTo(Integer value) {
            addCriterion("repertory <=", value, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryIn(List<Integer> values) {
            addCriterion("repertory in", values, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryNotIn(List<Integer> values) {
            addCriterion("repertory not in", values, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryBetween(Integer value1, Integer value2) {
            addCriterion("repertory between", value1, value2, "repertory");
            return (Criteria) this;
        }

        public Criteria andRepertoryNotBetween(Integer value1, Integer value2) {
            addCriterion("repertory not between", value1, value2, "repertory");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNull() {
            addCriterion("sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNotNull() {
            addCriterion("sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeEqualTo(Integer value) {
            addCriterion("sales_volume =", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotEqualTo(Integer value) {
            addCriterion("sales_volume <>", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThan(Integer value) {
            addCriterion("sales_volume >", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_volume >=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThan(Integer value) {
            addCriterion("sales_volume <", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("sales_volume <=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIn(List<Integer> values) {
            addCriterion("sales_volume in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotIn(List<Integer> values) {
            addCriterion("sales_volume not in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("sales_volume between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_volume not between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeIsNull() {
            addCriterion("virtual_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeIsNotNull() {
            addCriterion("virtual_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeEqualTo(Integer value) {
            addCriterion("virtual_sales_volume =", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeNotEqualTo(Integer value) {
            addCriterion("virtual_sales_volume <>", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeGreaterThan(Integer value) {
            addCriterion("virtual_sales_volume >", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("virtual_sales_volume >=", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeLessThan(Integer value) {
            addCriterion("virtual_sales_volume <", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("virtual_sales_volume <=", value, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeIn(List<Integer> values) {
            addCriterion("virtual_sales_volume in", values, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeNotIn(List<Integer> values) {
            addCriterion("virtual_sales_volume not in", values, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("virtual_sales_volume between", value1, value2, "virtualSalesVolume");
            return (Criteria) this;
        }

        public Criteria andVirtualSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("virtual_sales_volume not between", value1, value2, "virtualSalesVolume");
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