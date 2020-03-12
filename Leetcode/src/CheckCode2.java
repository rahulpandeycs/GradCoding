//Resolve a JSON Path
//        -------------------
//        Given a JSON input, find the nested value within the input when the input is an array/list or map/object.
//
//        Your Code
//        ---------
///**
// * For a given JSON input, return the resolved value for the given JSON Path.
// *
// * @param json     The Java representation of a JSON value
// * @param jsonPath The JSON Path (dot-delimited list of indices/keys)
// *
// * @return the resolved value or <code>null</code> when unresolvable
// */
//public static Object resolveJsonPath(Object json, String jsonPath) {
//        if (json == null) {
//        return null;
//        } else if (jsonPath == null) {
//        return null;
//        }
//
//        String[] jsonPathArray = jsonPath.split(“.”);
//        Object currValue = json;
//
//        for (String path : jsonPathArray){
//        if (currValue instanceof Map){
//        Map<String, Object> input = new HashMap<String, Object>(currValue);
//        if(input.contains(path)){
//        currValue = input.get(path);
//        continue;
//        } else
//        return null;
//        } else if (currValue instanceof List) {
//        List<Object> input = new ArrayList<>(currValue);
//        if(input.containsValue(path)){
//
//        }
//        }
//
//        }
//        return  output;
//        }
//
//        Sample JSON Paths (and results)
//        -------------------------------
//        "books" - Return the list of all books.
//        "books.imaginary" - null
//        "books.fiction.0.author" - Returns the string "Herman Melville".
//        "books.fiction.0.author.first_name" - null
//
//        Sample JSON Document
//        --------------------
//        {
//        "books": {
//        "fiction": [
//        {
//        "author": "Herman Melville",
//        "title": "Moby Dick",
//        "isbn": "978-0553213119",
//        "price": 8.99,
//        "related": ["978-0684801223", "978-0743273565"]
//        },
//        {
//        "author": "J. R. R. Tolkien",
//        "title": "The Lord of the Rings",
//        "isbn": "978-0395193952",
//        "price": 22.99,
//        "related": ["978-0547928241", "978-0345325815"]
//        }
//        ],
//        "nonfiction": [
//        {
//        "author": "Jared M. Diamond",
//        "title": "Guns, Germs, and Steel",
//        "isbn": "978-0393317558",
//        "price": 9.49,
//        "related": ["978-0062316097", "978-0143117001"]
//        },
//        {
//        "author": "Truman Capote",
//        "title": "In Cold Blood",
//        "isbn": "978-0679745587",
//        "price": 14.99,
//        "related": ["978-0393322231", "978-1981029877"]
//        }
//        ],
//        }
//        }
//
//
