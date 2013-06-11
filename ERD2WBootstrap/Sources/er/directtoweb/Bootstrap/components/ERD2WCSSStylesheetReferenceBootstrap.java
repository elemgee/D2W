package er.directtoweb.Bootstrap.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.directtoweb.D2WContext;
import com.webobjects.foundation.NSDictionary;

import er.directtoweb.components.ERD2WStatelessComponent;
import er.extensions.foundation.ERXProperties;

/**
 * Component to go in the <head> of a page. Injects the standandard set of css
 * stylesheets and the set defined in the rules
 * 
 * @property er.d2w.bootstrap.skinframework
 * 
 * @author davidleber
 */
public class ERD2WCSSStylesheetReferenceBootstrap extends
		ERD2WStatelessComponent {

	public String stylesheetName;

	public ERD2WCSSStylesheetReferenceBootstrap(WOContext context) {
		super(context);
	}

	@SuppressWarnings("unchecked")
	public NSDictionary<String, String> stylesheet() {
		return (NSDictionary<String, String>) d2wContext().valueForKey(
				stylesheetName);
	}

	@Override
	public D2WContext d2wContext() {
		return super.d2wContext();
	}

	public String resourceFrameworkName() {
		String fn = (String) stylesheet().valueForKey("framework");
		if (fn == null) {
			fn = ERXProperties.stringForKeyWithDefault(
					"er.d2w.bootstrap.skinframework", "app");
		}
		return fn;
	}
}
