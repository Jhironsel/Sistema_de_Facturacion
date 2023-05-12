package sur.softsurena.formularios;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.DataFactory;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewFrame;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;

public final class ShowReport {

    private final Integer id;
    private final String pathName;

    public ShowReport(Integer id, String pathName) {
        this.id = id;
        this.pathName = pathName;
        // initialize the Reporting Engine
        ClassicEngineBoot.getInstance().start();
        
        final MasterReport report = this.getCompleteReportDefinition();
        
        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        
        // Generate the swing preview dialog
        final PreviewFrame dialog = new PreviewFrame(report);

        dialog.setBounds(bounds);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    

    /**
     * Generates the report definition that has the data factory and parameters
     * already applied.
     *
     * @return the completed report definition
     */
    public  MasterReport getCompleteReportDefinition() {
        final MasterReport report = getReportDefinition();

        // Add any parameters to the report
        final Map<String, Object> reportParameters = this.getReportParameters();

        if (null != reportParameters) {
            for (String key : reportParameters.keySet()) {
                report.getParameterValues().put(key, reportParameters.get(key));
            }
        }

        // Set the data factory for the report
        final DataFactory dataFactory = getDataFactory();
        if (dataFactory != null) {
            report.setDataFactory(dataFactory);
        }

        // Return the completed report
        return report;
    }

    /**
     * Returns the report definition which will be used to generate the report.
     * In this case, the report will be loaded and parsed from a file contained
     * in this package.
     *
     * @return the loaded and parsed report definition to be used in report
     * generation.
     */
    private MasterReport getReportDefinition() {
        try {
            // Using the classloader, get the URL to the reportDefinition file
            // NOTE: We will re-use the report definition from SAMPLE1
            File file = new File(pathName);

            // Parse the report file
            final ResourceManager resourceManager = new ResourceManager();
            
            final Resource directly = resourceManager.createDirectly(file, MasterReport.class);
            
            return (MasterReport) directly.getResource();
        } catch (ResourceException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the set of runtime report parameters. This sample report uses the
     * following three parameters:
     * <ul>
     * <li><b>Report Title</b> - The title text on the top of the report</li>
     * <li><b>Customer Names</b> - an array of customer names to show in the
     * report</li>
     * <li><b>Col Headers BG Color</b> - the background color for the column
     * headers</li>
     * </ul>
     *
     * @return <code>null</code> indicating the report generator does not use
     * any report parameters
     */
    private Map<String, Object> getReportParameters() {
        final Map parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        return parameters;
    }

    /**
     * Returns the data factory which will be used to generate the data used
     * during report generation. In this example, we will return null since the
     * data factory has been defined in the report definition.
     *
     * @return the data factory used with the report generator
     */
    private DataFactory getDataFactory() {
        return null;
    }
}
