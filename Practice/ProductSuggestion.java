public static List<List> Productsuggestions(int numProducts, List<String> repository, String customerQuery) {
		List<List> productSuggestions = new ArrayList<>();
		customerQuery = customerQuery.toLowerCase();
		for (int i = 2; i <= customerQuery.length(); i++) {
			String check = customerQuery.substring(0, i);
			List ab = new ArrayList();
			for (String product : repository) {
				product = product.toLowerCase();
				if (product.startsWith(check)) {
					ab.add(product);
				}
			}
			ab = (List) ab.stream().sorted().limit(3).collect(Collectors.toList());
			productSuggestions.add(ab);
		}

		return productSuggestions;

	}