package com.vitorlucas.dslearnbds.observers;

import com.vitorlucas.dslearnbds.entities.Deliver;

public interface DeliverRevisionObserver {
	void onSaveRevision(Deliver deliver); 
}
