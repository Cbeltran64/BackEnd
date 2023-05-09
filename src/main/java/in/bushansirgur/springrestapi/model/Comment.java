package in.bushansirgur.springrestapi.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tbl_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Name should not be null")
    private String name;

    @NotNull(message = "codeEAN should not be null")
    private long codeEAN;

    @NotEmpty(message = "comment should not be null")
    @Size(min = 1, max = 1000, message = "comment must be between 1 and 1000 characters")
    private String comment;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @NotNull(message = "Image Url should not be blank")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCodeEAN() {
		return codeEAN;
	}

	public void setCodeEAN(long codeEAN) {
		this.codeEAN = codeEAN;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", codeEAN=" + codeEAN + ", comment=" + comment + ", createdAt="
				+ createdAt + ", imageUrl=" + imageUrl + ", product=" + product + "]";
	}

   

}
