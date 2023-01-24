public class App {
    // Android studio. Falta crear el campo birtdayET como EditText.
    // En un campo EditText creado para introducir la fecha de nacimiento de un
    // usuario.
    // Lo que hace este algoritmo es introducir "-" en los lugares correspondientes,
    // entre el día y el mes y el mes y el año. No dejando una longitud mayor del
    // número
    // total de caracteres y que cuando se borre se sigan poniendo igualmente.

    public static void main(String[] args) throws Exception {
        birthdateET.setTextChangeListener(new TextWatcher() {
	int prevL = 0;

	@Override
	public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
		prevL = birthdateET.getText().length();
	}

	@Override
	public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

	}

	@Override
	public void afterTextChanged(Editable s) {
		int length = s.length();
		String data = birthdateET.getText();
		if ((prevL < length) && (length == 2 || length == 5)) {
			data = data + "-";
			birthdateET.setTextFieldValue(data);
			birthdateET.setSelection(length + 1);
		} else if ((prevL < length) && (length == 3 || length == 6)) {
			if (!birthdateET.getText().equalsIgnoreCase(checkValue(data))) {
				data = checkValue(data);
				birthdateET.setTextFieldValue(data);
				birthdateET.setSelection(length + 1);
			}
		}
	}
});

    private String checkValue(String data) {
        String lastCharacter = data.substring(data.length() - 1);
        if (!lastCharacter.equalsIgnoreCase("-")) {
            return data.substring(0, data.length() - 1) + "-" + lastCharacter;
        }
        return data;
    }

}
