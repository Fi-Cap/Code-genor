package generator.Addons;

import generator.Addons.loader;
class AddonsInfo {
    String InfoText = new String();
    String name = new String();
    String Version = new String();
    String Description = new String();

    public String GetInfo() {
        return InfoText;
    }

    public AddonsInfo(String name, String version, String description) throws Exception {
        if (name == null) {
            Exception e = new Exception("Addons.MissingInfo: Missing Addons name");
            throw e;
        }

        if (version == null) {
            Exception e = new Exception("Addons.MissingInfo: Missing Addons version");
            throw e;
        }

        if (description == null) {
            Exception e = new Exception("Addons.MissingInfo: Missing Addons description");
            throw e;
        }

        if (version == "$mainVer") {
            version = "Core-" + loader.version();
        }
    }
}