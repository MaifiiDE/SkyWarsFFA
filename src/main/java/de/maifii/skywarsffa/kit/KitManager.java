package de.maifii.skywarsffa.kit;

import java.util.ArrayList;
import java.util.List;

public class KitManager {

    ArrayList<Kit> kits = new ArrayList<>();

    public void register(Kit... kits) {
        this.kits.addAll(List.of(kits));
    }

}
