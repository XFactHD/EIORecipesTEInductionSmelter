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

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}