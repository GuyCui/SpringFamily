/**
 * Generic framework code included with 
 * <a href="http://www.amazon.com/exec/obidos/tg/detail/-/1861007841/">Expert One-On-One J2EE Design and Development</a>
 * by Rod Johnson (Wrox, 2002). 
 * This code is free to use and modify. 
 * Please contact <a href="mailto:rod.johnson@interface21.com">rod.johnson@interface21.com</a>
 * for commercial support.
 */

package com.interface21.jdbc.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Callback interface used by the 
 * JdbcTemplate class. This interface sets values on a
 * a PreparedStatement provided by the
 * JdbcTemplate class for each of a number of updates in a batch using the
 * same SQL. Implementations are responsible
 * for setting any necessary parameters. SQL with placeholders
 * will already have been supplied.
 * Implementations <i>do not</i> need to concern themselves
 * with SQLExceptions that may be thrown from operations they
 * attempt. The JdbcTemplate class will catch and handle
 * SQLExceptions appropriately.
 * @version $Id: BatchPreparedStatementSetter.java,v 1.1 2003/04/23 20:55:22 johnsonr Exp $
 * @author Rod Johnson
 * @since March 2, 2003
 */
public interface BatchPreparedStatementSetter {

	/** 
	* Set values on the given PreparedStatement
	* @param ps PreparedStatement we'll invoke setter methods on
	* @param i index of the statement we're issuing in the batch,
	* from 0
	* @throws SQLException there is no need to catch SQLExceptions
	* that may be thrown in the implementation of this method.
	* The JdbcTemplate class will handle them.
	*/
	void setValues(PreparedStatement ps, int i) throws SQLException;
	
	/** 
	 * Return the size of the batch
	 */ 
	int getBatchSize();

}