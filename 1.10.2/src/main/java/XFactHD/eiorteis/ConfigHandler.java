package XFactHD.eiorteis;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{
    public static Configuration configuration;

    public static int energyConductiveIron  = 0;
    public static int energyPhasedIron      = 0;
    public static int energyEnergeticAlloy  = 0;
    public static int energyPhasedGold      = 0;
    public static int energyElectricalSteel = 0;
    public static int energyRedstoneAlloy   = 0;
    public static int energyDarkSteel       = 0;
    public static int energySoularium       = 0;
    public static int energyClearGlass      = 0;
    public static int energySiliconSingle   = 0;
    public static int energySiliconDouble   = 0;
    public static int energySiliconTripple  = 0;
    public static int energyClearGlass      = 0;
    public static int energyXPJuice         = 0;
    public static boolean addSiliconRecipe  = false;
    public static boolean addGlassRecipe    = false;
    public static boolean addXPJuiceRecipe  = false;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        energyConductiveIron  = configuration.getInt("energyConductiveIron", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Conductive Iron.");
        energyPhasedIron      = configuration.getInt("energyPhasedIron", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Pulsating Iron.");
        energyEnergeticAlloy  = configuration.getInt("energyEnergeticAlloy", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Energetic Alloy.");
        energyPhasedGold      = configuration.getInt("energyPhasedGold", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Vibrant Alloy.");
        energyElectricalSteel = configuration.getInt("energyElectricalSteel", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Electrical Steel.");
        energyRedstoneAlloy   = configuration.getInt("energyRedstoneAlloy", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Redstone Alloy.");
        energyDarkSteel       = configuration.getInt("energyDarkSteel", "Energy Consumption", 20000, 1, 100000, "Sets the energy consumption for the produstion of Dark Steel.");
        energySoularium       = configuration.getInt("energySoularium", "Energy Consumption", 10000, 1, 100000, "Sets the energy consumption for the produstion of Soularium.");

        energyClearGlass      = configuration.getInt("energyClearGlass", "Energy Consumption", 200, 1, 5000, "Sets the energy consumption for the production of Quite Clear Glass.");
        
        addSiliconRecipe      = configuration.getBoolean("addSiliconRecipe", "Features", true, "If true, recipes to create Silicon from Sand will be added to the Pulverizer");
        energySiliconSingle   = configuration.getInt("energySiliconSingle", "Energy Consumption", 720, 1, 100000, "Sets the energy consumption for the production of Silicon from Sand");
        energySiliconDouble   = configuration.getInt("energySiliconDouble", "Energy Consumption", 7200, 1, 1000000, "Sets the energy consumption for the production of Silicon from Compressed Sand");
        energySiliconTripple  = configuration.getInt("energySiliconTripple", "Energy Consumption", 72000, 1, 1000000, "Sets the energy consumption for the production of Silicon from Double Compressed Sand");

        addGlassRecipe        = configuration.getBoolean("addGlassRecipe", "Features", true, "If true, a recipe to create Quite Clear Glass will be added to the Induction Smelter");
        energyClearGlass      = configuration.getInt("energyClearGlass", "Energy Consumption", 2500, 1, 100000, "Sets the energy consumption for the production of Quite Clear Glass");

        addXPJuiceRecipe      = configuration.getBoolean("addXPJuiceRecipe", "Features", true, "If true and Woot is installed, a recipe to create Liquid XP from Woot XP Shards will be added to the Magma Crucible");
        energyXPJuice         = configuration.getInt("energyXPJuice", "Energy Consumption", 20, 1, 10000, "Sets the energy consumption for the production of Liquid XP");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}