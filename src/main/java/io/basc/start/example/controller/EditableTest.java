package io.basc.start.example.controller;

import io.basc.framework.orm.annotation.PrimaryKey;
import io.basc.start.data.annotation.Editable;
import io.basc.start.data.annotation.Image;
import lombok.Data;

@Editable(title = "可编辑测试")
@Data
public class EditableTest {
	@PrimaryKey
	private String name;
	@Image
	private String img;
	@Image(multiple = true)
	private String imgs;
}
