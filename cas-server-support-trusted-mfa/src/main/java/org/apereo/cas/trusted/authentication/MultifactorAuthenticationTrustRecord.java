package org.apereo.cas.trusted.authentication;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

/**
 * This is {@link MultifactorAuthenticationTrustRecord}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
public class MultifactorAuthenticationTrustRecord implements Comparable<MultifactorAuthenticationTrustRecord> {
    private String principal;
    private String geography;
    private LocalDate date;
    private String key;
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(final String id) {
        this.key = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(final String principal) {
        this.principal = principal;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(final String geography) {
        this.geography = geography;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final MultifactorAuthenticationTrustRecord rhs = (MultifactorAuthenticationTrustRecord) obj;
        return new EqualsBuilder()
                .append(this.principal, rhs.principal)
                .append(this.geography, rhs.geography)
                .append(this.date, rhs.date)
                .append(this.key, rhs.key)
                .append(this.name, rhs.name)
                .isEquals();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(principal)
                .append(geography)
                .append(date)
                .append(key)
                .append(name)
                .toHashCode();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("principal", principal)
                .append("geography", geography)
                .append("date", date)
                .append("name", name)
                .toString();
    }

    /**
     * New instance of authentication trust record.
     *
     * @param principal the principal
     * @param geography the geography
     * @return the authentication trust record
     */
    public static MultifactorAuthenticationTrustRecord newInstance(final String principal, final String geography) {
        final MultifactorAuthenticationTrustRecord r = new MultifactorAuthenticationTrustRecord();
        r.setDate(LocalDate.now());
        r.setPrincipal(principal);
        r.setGeography(geography);
        r.setName(principal.concat("-").concat(LocalDate.now().toString()).concat("-").concat(geography));
        return r;
    }
    
    @Override
    public int compareTo(final MultifactorAuthenticationTrustRecord o) {
        return this.date.compareTo(o.getDate());
    }
}
