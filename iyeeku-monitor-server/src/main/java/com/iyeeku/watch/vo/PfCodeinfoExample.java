package com.iyeeku.watch.vo;

import java.util.ArrayList;
import java.util.List;

public class PfCodeinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PfCodeinfoExample() {
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

        public Criteria andZjIsNull() {
            addCriterion("ZJ is null");
            return (Criteria) this;
        }

        public Criteria andZjIsNotNull() {
            addCriterion("ZJ is not null");
            return (Criteria) this;
        }

        public Criteria andZjEqualTo(String value) {
            addCriterion("ZJ =", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjNotEqualTo(String value) {
            addCriterion("ZJ <>", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjGreaterThan(String value) {
            addCriterion("ZJ >", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjGreaterThanOrEqualTo(String value) {
            addCriterion("ZJ >=", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjLessThan(String value) {
            addCriterion("ZJ <", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjLessThanOrEqualTo(String value) {
            addCriterion("ZJ <=", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjLike(String value) {
            addCriterion("ZJ like", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjNotLike(String value) {
            addCriterion("ZJ not like", value, "zj");
            return (Criteria) this;
        }

        public Criteria andZjIn(List<String> values) {
            addCriterion("ZJ in", values, "zj");
            return (Criteria) this;
        }

        public Criteria andZjNotIn(List<String> values) {
            addCriterion("ZJ not in", values, "zj");
            return (Criteria) this;
        }

        public Criteria andZjBetween(String value1, String value2) {
            addCriterion("ZJ between", value1, value2, "zj");
            return (Criteria) this;
        }

        public Criteria andZjNotBetween(String value1, String value2) {
            addCriterion("ZJ not between", value1, value2, "zj");
            return (Criteria) this;
        }

        public Criteria andMblxbhIsNull() {
            addCriterion("MBLXBH is null");
            return (Criteria) this;
        }

        public Criteria andMblxbhIsNotNull() {
            addCriterion("MBLXBH is not null");
            return (Criteria) this;
        }

        public Criteria andMblxbhEqualTo(String value) {
            addCriterion("MBLXBH =", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhNotEqualTo(String value) {
            addCriterion("MBLXBH <>", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhGreaterThan(String value) {
            addCriterion("MBLXBH >", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhGreaterThanOrEqualTo(String value) {
            addCriterion("MBLXBH >=", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhLessThan(String value) {
            addCriterion("MBLXBH <", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhLessThanOrEqualTo(String value) {
            addCriterion("MBLXBH <=", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhLike(String value) {
            addCriterion("MBLXBH like", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhNotLike(String value) {
            addCriterion("MBLXBH not like", value, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhIn(List<String> values) {
            addCriterion("MBLXBH in", values, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhNotIn(List<String> values) {
            addCriterion("MBLXBH not in", values, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhBetween(String value1, String value2) {
            addCriterion("MBLXBH between", value1, value2, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMblxbhNotBetween(String value1, String value2) {
            addCriterion("MBLXBH not between", value1, value2, "mblxbh");
            return (Criteria) this;
        }

        public Criteria andMbtmzIsNull() {
            addCriterion("MBTMZ is null");
            return (Criteria) this;
        }

        public Criteria andMbtmzIsNotNull() {
            addCriterion("MBTMZ is not null");
            return (Criteria) this;
        }

        public Criteria andMbtmzEqualTo(String value) {
            addCriterion("MBTMZ =", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzNotEqualTo(String value) {
            addCriterion("MBTMZ <>", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzGreaterThan(String value) {
            addCriterion("MBTMZ >", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzGreaterThanOrEqualTo(String value) {
            addCriterion("MBTMZ >=", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzLessThan(String value) {
            addCriterion("MBTMZ <", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzLessThanOrEqualTo(String value) {
            addCriterion("MBTMZ <=", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzLike(String value) {
            addCriterion("MBTMZ like", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzNotLike(String value) {
            addCriterion("MBTMZ not like", value, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzIn(List<String> values) {
            addCriterion("MBTMZ in", values, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzNotIn(List<String> values) {
            addCriterion("MBTMZ not in", values, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzBetween(String value1, String value2) {
            addCriterion("MBTMZ between", value1, value2, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andMbtmzNotBetween(String value1, String value2) {
            addCriterion("MBTMZ not between", value1, value2, "mbtmz");
            return (Criteria) this;
        }

        public Criteria andSjlxIsNull() {
            addCriterion("SJLX is null");
            return (Criteria) this;
        }

        public Criteria andSjlxIsNotNull() {
            addCriterion("SJLX is not null");
            return (Criteria) this;
        }

        public Criteria andSjlxEqualTo(String value) {
            addCriterion("SJLX =", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotEqualTo(String value) {
            addCriterion("SJLX <>", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxGreaterThan(String value) {
            addCriterion("SJLX >", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxGreaterThanOrEqualTo(String value) {
            addCriterion("SJLX >=", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLessThan(String value) {
            addCriterion("SJLX <", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLessThanOrEqualTo(String value) {
            addCriterion("SJLX <=", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLike(String value) {
            addCriterion("SJLX like", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotLike(String value) {
            addCriterion("SJLX not like", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxIn(List<String> values) {
            addCriterion("SJLX in", values, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotIn(List<String> values) {
            addCriterion("SJLX not in", values, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxBetween(String value1, String value2) {
            addCriterion("SJLX between", value1, value2, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotBetween(String value1, String value2) {
            addCriterion("SJLX not between", value1, value2, "sjlx");
            return (Criteria) this;
        }

        public Criteria andMbtmmsIsNull() {
            addCriterion("MBTMMS is null");
            return (Criteria) this;
        }

        public Criteria andMbtmmsIsNotNull() {
            addCriterion("MBTMMS is not null");
            return (Criteria) this;
        }

        public Criteria andMbtmmsEqualTo(String value) {
            addCriterion("MBTMMS =", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsNotEqualTo(String value) {
            addCriterion("MBTMMS <>", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsGreaterThan(String value) {
            addCriterion("MBTMMS >", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsGreaterThanOrEqualTo(String value) {
            addCriterion("MBTMMS >=", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsLessThan(String value) {
            addCriterion("MBTMMS <", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsLessThanOrEqualTo(String value) {
            addCriterion("MBTMMS <=", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsLike(String value) {
            addCriterion("MBTMMS like", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsNotLike(String value) {
            addCriterion("MBTMMS not like", value, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsIn(List<String> values) {
            addCriterion("MBTMMS in", values, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsNotIn(List<String> values) {
            addCriterion("MBTMMS not in", values, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsBetween(String value1, String value2) {
            addCriterion("MBTMMS between", value1, value2, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andMbtmmsNotBetween(String value1, String value2) {
            addCriterion("MBTMMS not between", value1, value2, "mbtmms");
            return (Criteria) this;
        }

        public Criteria andSjsxsyIsNull() {
            addCriterion("SJSXSY is null");
            return (Criteria) this;
        }

        public Criteria andSjsxsyIsNotNull() {
            addCriterion("SJSXSY is not null");
            return (Criteria) this;
        }

        public Criteria andSjsxsyEqualTo(Integer value) {
            addCriterion("SJSXSY =", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyNotEqualTo(Integer value) {
            addCriterion("SJSXSY <>", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyGreaterThan(Integer value) {
            addCriterion("SJSXSY >", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SJSXSY >=", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyLessThan(Integer value) {
            addCriterion("SJSXSY <", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyLessThanOrEqualTo(Integer value) {
            addCriterion("SJSXSY <=", value, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyIn(List<Integer> values) {
            addCriterion("SJSXSY in", values, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyNotIn(List<Integer> values) {
            addCriterion("SJSXSY not in", values, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyBetween(Integer value1, Integer value2) {
            addCriterion("SJSXSY between", value1, value2, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andSjsxsyNotBetween(Integer value1, Integer value2) {
            addCriterion("SJSXSY not between", value1, value2, "sjsxsy");
            return (Criteria) this;
        }

        public Criteria andGjdbmIsNull() {
            addCriterion("GJDBM is null");
            return (Criteria) this;
        }

        public Criteria andGjdbmIsNotNull() {
            addCriterion("GJDBM is not null");
            return (Criteria) this;
        }

        public Criteria andGjdbmEqualTo(String value) {
            addCriterion("GJDBM =", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmNotEqualTo(String value) {
            addCriterion("GJDBM <>", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmGreaterThan(String value) {
            addCriterion("GJDBM >", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmGreaterThanOrEqualTo(String value) {
            addCriterion("GJDBM >=", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmLessThan(String value) {
            addCriterion("GJDBM <", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmLessThanOrEqualTo(String value) {
            addCriterion("GJDBM <=", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmLike(String value) {
            addCriterion("GJDBM like", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmNotLike(String value) {
            addCriterion("GJDBM not like", value, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmIn(List<String> values) {
            addCriterion("GJDBM in", values, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmNotIn(List<String> values) {
            addCriterion("GJDBM not in", values, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmBetween(String value1, String value2) {
            addCriterion("GJDBM between", value1, value2, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andGjdbmNotBetween(String value1, String value2) {
            addCriterion("GJDBM not between", value1, value2, "gjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmIsNull() {
            addCriterion("FJDBM is null");
            return (Criteria) this;
        }

        public Criteria andFjdbmIsNotNull() {
            addCriterion("FJDBM is not null");
            return (Criteria) this;
        }

        public Criteria andFjdbmEqualTo(String value) {
            addCriterion("FJDBM =", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmNotEqualTo(String value) {
            addCriterion("FJDBM <>", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmGreaterThan(String value) {
            addCriterion("FJDBM >", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmGreaterThanOrEqualTo(String value) {
            addCriterion("FJDBM >=", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmLessThan(String value) {
            addCriterion("FJDBM <", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmLessThanOrEqualTo(String value) {
            addCriterion("FJDBM <=", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmLike(String value) {
            addCriterion("FJDBM like", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmNotLike(String value) {
            addCriterion("FJDBM not like", value, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmIn(List<String> values) {
            addCriterion("FJDBM in", values, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmNotIn(List<String> values) {
            addCriterion("FJDBM not in", values, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmBetween(String value1, String value2) {
            addCriterion("FJDBM between", value1, value2, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andFjdbmNotBetween(String value1, String value2) {
            addCriterion("FJDBM not between", value1, value2, "fjdbm");
            return (Criteria) this;
        }

        public Criteria andBmjbIsNull() {
            addCriterion("BMJB is null");
            return (Criteria) this;
        }

        public Criteria andBmjbIsNotNull() {
            addCriterion("BMJB is not null");
            return (Criteria) this;
        }

        public Criteria andBmjbEqualTo(Short value) {
            addCriterion("BMJB =", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotEqualTo(Short value) {
            addCriterion("BMJB <>", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbGreaterThan(Short value) {
            addCriterion("BMJB >", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbGreaterThanOrEqualTo(Short value) {
            addCriterion("BMJB >=", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbLessThan(Short value) {
            addCriterion("BMJB <", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbLessThanOrEqualTo(Short value) {
            addCriterion("BMJB <=", value, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbIn(List<Short> values) {
            addCriterion("BMJB in", values, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotIn(List<Short> values) {
            addCriterion("BMJB not in", values, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbBetween(Short value1, Short value2) {
            addCriterion("BMJB between", value1, value2, "bmjb");
            return (Criteria) this;
        }

        public Criteria andBmjbNotBetween(Short value1, Short value2) {
            addCriterion("BMJB not between", value1, value2, "bmjb");
            return (Criteria) this;
        }

        public Criteria andQljIsNull() {
            addCriterion("QLJ is null");
            return (Criteria) this;
        }

        public Criteria andQljIsNotNull() {
            addCriterion("QLJ is not null");
            return (Criteria) this;
        }

        public Criteria andQljEqualTo(String value) {
            addCriterion("QLJ =", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljNotEqualTo(String value) {
            addCriterion("QLJ <>", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljGreaterThan(String value) {
            addCriterion("QLJ >", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljGreaterThanOrEqualTo(String value) {
            addCriterion("QLJ >=", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljLessThan(String value) {
            addCriterion("QLJ <", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljLessThanOrEqualTo(String value) {
            addCriterion("QLJ <=", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljLike(String value) {
            addCriterion("QLJ like", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljNotLike(String value) {
            addCriterion("QLJ not like", value, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljIn(List<String> values) {
            addCriterion("QLJ in", values, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljNotIn(List<String> values) {
            addCriterion("QLJ not in", values, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljBetween(String value1, String value2) {
            addCriterion("QLJ between", value1, value2, "qlj");
            return (Criteria) this;
        }

        public Criteria andQljNotBetween(String value1, String value2) {
            addCriterion("QLJ not between", value1, value2, "qlj");
            return (Criteria) this;
        }

        public Criteria andSfkjIsNull() {
            addCriterion("SFKJ is null");
            return (Criteria) this;
        }

        public Criteria andSfkjIsNotNull() {
            addCriterion("SFKJ is not null");
            return (Criteria) this;
        }

        public Criteria andSfkjEqualTo(String value) {
            addCriterion("SFKJ =", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjNotEqualTo(String value) {
            addCriterion("SFKJ <>", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjGreaterThan(String value) {
            addCriterion("SFKJ >", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjGreaterThanOrEqualTo(String value) {
            addCriterion("SFKJ >=", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjLessThan(String value) {
            addCriterion("SFKJ <", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjLessThanOrEqualTo(String value) {
            addCriterion("SFKJ <=", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjLike(String value) {
            addCriterion("SFKJ like", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjNotLike(String value) {
            addCriterion("SFKJ not like", value, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjIn(List<String> values) {
            addCriterion("SFKJ in", values, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjNotIn(List<String> values) {
            addCriterion("SFKJ not in", values, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjBetween(String value1, String value2) {
            addCriterion("SFKJ between", value1, value2, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSfkjNotBetween(String value1, String value2) {
            addCriterion("SFKJ not between", value1, value2, "sfkj");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxIsNull() {
            addCriterion("SJSYGJHXX is null");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxIsNotNull() {
            addCriterion("SJSYGJHXX is not null");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxEqualTo(String value) {
            addCriterion("SJSYGJHXX =", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxNotEqualTo(String value) {
            addCriterion("SJSYGJHXX <>", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxGreaterThan(String value) {
            addCriterion("SJSYGJHXX >", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxGreaterThanOrEqualTo(String value) {
            addCriterion("SJSYGJHXX >=", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxLessThan(String value) {
            addCriterion("SJSYGJHXX <", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxLessThanOrEqualTo(String value) {
            addCriterion("SJSYGJHXX <=", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxLike(String value) {
            addCriterion("SJSYGJHXX like", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxNotLike(String value) {
            addCriterion("SJSYGJHXX not like", value, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxIn(List<String> values) {
            addCriterion("SJSYGJHXX in", values, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxNotIn(List<String> values) {
            addCriterion("SJSYGJHXX not in", values, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxBetween(String value1, String value2) {
            addCriterion("SJSYGJHXX between", value1, value2, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andSjsygjhxxNotBetween(String value1, String value2) {
            addCriterion("SJSYGJHXX not between", value1, value2, "sjsygjhxx");
            return (Criteria) this;
        }

        public Criteria andJlztIsNull() {
            addCriterion("JLZT is null");
            return (Criteria) this;
        }

        public Criteria andJlztIsNotNull() {
            addCriterion("JLZT is not null");
            return (Criteria) this;
        }

        public Criteria andJlztEqualTo(String value) {
            addCriterion("JLZT =", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotEqualTo(String value) {
            addCriterion("JLZT <>", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztGreaterThan(String value) {
            addCriterion("JLZT >", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztGreaterThanOrEqualTo(String value) {
            addCriterion("JLZT >=", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLessThan(String value) {
            addCriterion("JLZT <", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLessThanOrEqualTo(String value) {
            addCriterion("JLZT <=", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztLike(String value) {
            addCriterion("JLZT like", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotLike(String value) {
            addCriterion("JLZT not like", value, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztIn(List<String> values) {
            addCriterion("JLZT in", values, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotIn(List<String> values) {
            addCriterion("JLZT not in", values, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztBetween(String value1, String value2) {
            addCriterion("JLZT between", value1, value2, "jlzt");
            return (Criteria) this;
        }

        public Criteria andJlztNotBetween(String value1, String value2) {
            addCriterion("JLZT not between", value1, value2, "jlzt");
            return (Criteria) this;
        }

        public Criteria andKzzdIsNull() {
            addCriterion("KZZD is null");
            return (Criteria) this;
        }

        public Criteria andKzzdIsNotNull() {
            addCriterion("KZZD is not null");
            return (Criteria) this;
        }

        public Criteria andKzzdEqualTo(String value) {
            addCriterion("KZZD =", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdNotEqualTo(String value) {
            addCriterion("KZZD <>", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdGreaterThan(String value) {
            addCriterion("KZZD >", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdGreaterThanOrEqualTo(String value) {
            addCriterion("KZZD >=", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdLessThan(String value) {
            addCriterion("KZZD <", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdLessThanOrEqualTo(String value) {
            addCriterion("KZZD <=", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdLike(String value) {
            addCriterion("KZZD like", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdNotLike(String value) {
            addCriterion("KZZD not like", value, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdIn(List<String> values) {
            addCriterion("KZZD in", values, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdNotIn(List<String> values) {
            addCriterion("KZZD not in", values, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdBetween(String value1, String value2) {
            addCriterion("KZZD between", value1, value2, "kzzd");
            return (Criteria) this;
        }

        public Criteria andKzzdNotBetween(String value1, String value2) {
            addCriterion("KZZD not between", value1, value2, "kzzd");
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