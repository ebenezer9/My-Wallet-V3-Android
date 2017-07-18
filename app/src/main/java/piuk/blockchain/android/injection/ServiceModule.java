package piuk.blockchain.android.injection;

import info.blockchain.wallet.api.trade.coinify.CoinifyApi;
import info.blockchain.wallet.api.trade.sfox.SFOXApi;
import info.blockchain.wallet.contacts.Contacts;
import info.blockchain.wallet.payload.PayloadManager;
import info.blockchain.wallet.settings.SettingsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import piuk.blockchain.android.data.rxjava.RxBus;
import piuk.blockchain.android.data.services.ContactsService;
import piuk.blockchain.android.data.services.ExchangeService;
import piuk.blockchain.android.data.settings.SettingsService;

@Module
class ServiceModule {

    @Provides
    @Singleton
    SettingsService provideSettingsService() {
        return new SettingsService(new SettingsManager());
    }

    @Provides
    @Singleton
    ExchangeService provideExchangeService(PayloadManager payloadManager, RxBus rxBus) {
        return new ExchangeService(payloadManager, rxBus, new CoinifyApi(), new SFOXApi());
    }

    @Provides
    @Singleton
    ContactsService provideContactsService() {
        return new ContactsService(new Contacts());
    }

}
