

import UIKit

class FruitDetailPresenter: FruitDetailPresenterProtocol {
    
    weak var view: FruitDetailViewProtocol?
    var wireframe: FruitDetailWireFrameProtocol?
    var fruit: Fruit?
    
    func viewDidLoad() {
        view?.showFruitDetail(with: fruit!)
    }
    
    func backButtonPressed(from view: UIViewController) {
        
    }
    
    deinit {
        print("FruitDetailPresenter removed")
    }
    
}
