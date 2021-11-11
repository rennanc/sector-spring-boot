export const addErrorAtFormField = (campo) => {
	removeSuccessFormField(campo);
	$(campo).addClass("is-invalid");
};

export const removeErrorFormField = (campo) => {
	$(campo).removeClass("is-invalid");
};

export const removeSuccessFormField = (campo) => {
	$(campo).removeClass("is-valid");
};