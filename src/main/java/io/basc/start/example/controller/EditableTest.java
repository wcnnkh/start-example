package io.basc.start.example.controller;

import io.basc.framework.orm.annotation.Condition;
import io.basc.framework.orm.annotation.Entity;
import io.basc.framework.orm.annotation.PrimaryKey;
import io.basc.framework.orm.annotation.SortType;
import io.basc.framework.util.comparator.Sort;
import io.basc.start.editable.annotation.Editable;
import io.basc.start.editable.annotation.Image;
import lombok.Data;

@Editable
@Entity(comment = "可编辑测试")
@Data
public class EditableTest {
	@PrimaryKey
	private String name;
	@Image
	@Condition("like")
	private String img;
	@Image(multiple = true)
	@SortType(Sort.DESC)
	private String imgs;
}
