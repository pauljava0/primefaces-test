package org.primefaces.test;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.PostConstructApplicationEvent;
import jakarta.faces.event.SystemEvent;
import jakarta.faces.event.SystemEventListener;

import org.primefaces.metadata.transformer.MetadataTransformerExecutor;
import org.primefaces.metadata.transformer.impl.BeanValidationInputMetadataTransformer;

public class TestListener implements SystemEventListener
{

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException
	{
		if (event instanceof PostConstructApplicationEvent)
		{
			// any instance of MetadataTransformer can be used here to reproduce the issue
			MetadataTransformerExecutor.registerMetadataTransformer(new BeanValidationInputMetadataTransformer());
		}
	}

	@Override
	public boolean isListenerForSource(Object source)
	{
		return true;
	}
}
