package by.gsu.epamlab.model.beans;

public enum Role {
	VIEWER, COURIER, ADMIN;

	public String toString() {
		return this.name().toLowerCase();
	}

	public boolean equals(Role role) {
		if (role == null) {
			return false;
		}
		
		if (this == role) {
			return true;
		}
		if (this.name().equals(role.name())) {
			return true;
		}
		return false;
	}
}
