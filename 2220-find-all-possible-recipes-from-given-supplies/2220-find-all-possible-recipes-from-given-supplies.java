class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> output = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String n : supplies) set.add(n);
        boolean addedNewRecipe = true;
        while (addedNewRecipe) { 
            addedNewRecipe = false;
            for (int i = 0; i < recipes.length; i++) {
                if (set.contains(recipes[i])) continue; 
                boolean canMake = true;
                for (String ing : ingredients.get(i)) {
                    if (!set.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }         
                if (canMake) {
                    output.add(recipes[i]);
                    set.add(recipes[i]);
                    addedNewRecipe = true;
                }
            }
        }
        return output;
    }
}