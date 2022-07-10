package main;

/**
 * Enumeration class CertificateStatusEnum represents the possible states of the
 * certificate. The statuses that have been established are as follows:
 * 
 * <ol>
 * <li>NEW: the certificate has been created.</li>
 * <li>BUDGETED: the budget has been established.</li>
 * <li>PENDING: the visit is pending.</li>
 * <li>ISSUED: the certificate has been issued.<li> 
 * <li>DELIVERED: the certificate has been delivered to the client.</li>
 * </ol>
 * 
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public enum CertificateStatusEnum {
	NEW, BUDGETED, PENDING, ISSUED, DELIVERED
}
