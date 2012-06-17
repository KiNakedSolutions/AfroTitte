package com.kinakedsolutions.afrotitte.loveobjects;

/**
 * The Woman is the default LoveObject implementation.
 * It has properties
 */
public class Woman extends BasicLoveObject {
	
	// Woman specific properties
	private final int age;
	private final int height;
	private final float weight;
	// etc. whatever :p
	
	/**
	 * Use the {@link WomanBuilder} to configure a woman's immutable properties. 
	 */
	private Woman(WomanBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.height = builder.height;
		this.weight = builder.weight;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public static class WomanBuilder implements Builder<Woman> {
		// required
		private String name;
		// optional
		private int age = 18;
		private int height = 170;
		private float weight = 60;
		
		/**
		 * Used to build women. 
		 * @param name	the woman's name.
		 */
		public WomanBuilder(String name) {
			this.name = name;
		}

		public WomanBuilder setName(String name) {
			this.name = name; return this;
		}

		public WomanBuilder setAge(int age) {
			this.age = age; return this;
		}

		public WomanBuilder setHeight(int height) {
			this.height = height; return this;
		}

		public WomanBuilder setWeight(float weight) {
			this.weight = weight; return this;
		}
		
		/**
		 * Builds a new woman according to the settings of this builder.
		 * @return a woman
		 */
		public Woman build() {
			return new Woman(this);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name).append(":[age=").append(age)
			.append(", height=").append(height)
			.append("cm, weight=").append(weight)
			.append("kg]");
		return builder.toString();
	}
	
	
}
