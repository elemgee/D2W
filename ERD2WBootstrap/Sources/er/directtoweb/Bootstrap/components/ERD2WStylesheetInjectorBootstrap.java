package er.directtoweb.Bootstrap.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSDictionary;

import er.directtoweb.components.ERD2WStatelessComponent;
import er.extensions.foundation.ERXProperties;


/**
 * Borrowed from the ERModernDirect2Web framework. I know this is not good component 
 * copying instead of re-use, but the reliance of ERMOdernD2W on the Ajax framework is 
 * something I want to try to work out of since Bootstrap likes jQuery best of all...
 * @property er.d2w.bootstrap.skinframework
 * @author lmg42
 * @author ERMD2WStyleSheetInjector is  David LeBer
 * @see er.modern.directtoweb.components.ERMD2WStyleSheetInjector
 * @see er.directtoweb.components.ERD2WStatelessComponent
 */
public class ERD2WStylesheetInjectorBootstrap  extends ERD2WStatelessComponent {
	
	public String stylesheetName;
	
	
    public ERD2WStylesheetInjectorBootstrap(WOContext context) {
        super(context);
    }
    
    
    @SuppressWarnings("unchecked")
   	public NSDictionary<String, String> stylesheet() {
       	return (NSDictionary<String, String>)d2wContext().valueForKey(stylesheetName);
       }
       
       /**
        * The name of the stylsheet framework name.
        * <p>
        * Looks for a property named er.modern.look.skinframework (which should be supplied by
        * the skin framework, otherwise defaults to 'app'
        */
       public String resourceFrameworkName() {
       	String fn = (String)stylesheet().valueForKey("framework");
       	if (fn == null) {
       		fn = ERXProperties.stringForKeyWithDefault("er.d2w.bootstrap.skinframework", "app");
       	}
       	return fn;
       }
}