/**
 * This class is generated by jOOQ
 */
package org.jooq.test.jdbcoracle.generatedclasses.test.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Dr$iBookTitleContext$n implements org.jooq.test.jdbcoracle.generatedclasses.test.tables.interfaces.IDr$iBookTitleContext$n {

	private static final long serialVersionUID = -1694644599;

	private java.math.BigInteger nltDocid;
	private java.lang.String     nltMark;

	@Override
	public java.math.BigInteger getNltDocid() {
		return this.nltDocid;
	}

	@Override
	public void setNltDocid(java.math.BigInteger nltDocid) {
		this.nltDocid = nltDocid;
	}

	@Override
	public java.lang.String getNltMark() {
		return this.nltMark;
	}

	@Override
	public void setNltMark(java.lang.String nltMark) {
		this.nltMark = nltMark;
	}

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void from(org.jooq.test.jdbcoracle.generatedclasses.test.tables.interfaces.IDr$iBookTitleContext$n from) {
		setNltDocid(from.getNltDocid());
		setNltMark(from.getNltMark());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <E extends org.jooq.test.jdbcoracle.generatedclasses.test.tables.interfaces.IDr$iBookTitleContext$n> E into(E into) {
		into.from(this);
		return into;
	}
}